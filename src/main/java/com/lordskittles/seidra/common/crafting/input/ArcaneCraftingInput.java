package com.lordskittles.seidra.common.crafting.input;

import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.ArrayList;
import java.util.List;

public class ArcaneCraftingInput implements RecipeInput
{
    public static final ArcaneCraftingInput EMPTY = new ArcaneCraftingInput(0, 0, List.of(), 0);

    private final int width;
    private final int height;

    private final List<ItemStack> items;
    private final int ingredientCount;
    private final int saiCost;

    private final StackedContents stackedContents = new StackedContents();

    private ArcaneCraftingInput(int width, int height, List<ItemStack> items, int saiCost)
    {
        this.width = width;
        this.height = height;
        this.items = items;
        this.saiCost = saiCost;

        int i = 0;
        for (ItemStack item : items)
        {
            if (!item.isEmpty())
            {
                ++i;
                this.stackedContents.accountStack(item);
            }
        }

        this.ingredientCount = i;
    }

    public static ArcaneCraftingInput of(int width, int height, List<ItemStack> items, int saiCost)
    {
        return ofPositioned(width, height, items, saiCost).input();
    }

    public static Positioned ofPositioned(int width, int height, List<ItemStack> items, int saiCost)
    {
        if (width != 0 && height != 0)
        {
            int minX = width - 1;
            int maxX = 0;
            int minY = height - 1;
            int maxY = 0;
            for (int row = 0; row < height; ++row)
            {
                boolean hasNonEmptyItems = true;

                for (int col = 0; col < width; ++col)
                {
                    ItemStack itemstack = items.get(col + row * width);
                    if (!itemstack.isEmpty())
                    {
                        minX = Math.min(minX, col);
                        maxX = Math.max(maxX, col);
                        hasNonEmptyItems = false;
                    }
                }

                if (!hasNonEmptyItems)
                {
                    minY = Math.min(minY, row);
                    maxY = Math.max(maxY, row);
                }
            }

            int boundingWidth = maxX - minX + 1;
            int boundingHeight = maxY - minY + 1;
            if (boundingWidth > 0 && boundingHeight > 0)
            {
                if (boundingWidth == width && boundingHeight == height)
                {
                    return new ArcaneCraftingInput.Positioned(new ArcaneCraftingInput(width, height, items, saiCost), minX, minY);
                }
                else
                {
                    List<ItemStack> list = new ArrayList<>(boundingWidth * boundingHeight);

                    for (int boundingRow = 0; boundingRow < boundingHeight; ++boundingRow)
                    {
                        for (int boundingCol = 0; boundingCol < boundingWidth; ++boundingCol)
                        {
                            int originalIndex = boundingCol + minX + (boundingRow + minY) * width;
                            list.add(items.get(originalIndex));
                        }
                    }

                    return new ArcaneCraftingInput.Positioned(new ArcaneCraftingInput(boundingWidth, boundingHeight, list, saiCost), minX, minY);
                }
            }
            else
            {
                return ArcaneCraftingInput.Positioned.EMPTY;
            }
        }
        else
        {
            return ArcaneCraftingInput.Positioned.EMPTY;
        }
    }

    public CraftingInput toCraftingInput()
    {
        return CraftingInput.of(this.width, this.height, this.items);
    }

    @Override
    public ItemStack getItem(int index)
    {
        return this.items.get(index);
    }

    public ItemStack getItem(int row, int col)
    {
        return this.items.get(col + row * this.width);
    }

    @Override
    public int size()
    {
        return this.items.size();
    }

    public boolean isEmpty()
    {
        return this.ingredientCount == 0;
    }

    public StackedContents stackedContents()
    {
        return this.stackedContents;
    }

    public List<ItemStack> items()
    {
        return this.items;
    }

    public int ingredientCount()
    {
        return this.ingredientCount;
    }

    public int width()
    {
        return this.width;
    }

    public int height()
    {
        return this.height;
    }

    public int saiCost()
    {
        return this.saiCost;
    }

    @Override
    public boolean equals(Object other)
    {
        if (other == this)
        {
            return true;
        }

        boolean matches = false;
        if (other instanceof ArcaneCraftingInput arcaneCraftingInput)
        {
            matches = this.width == arcaneCraftingInput.width && this.height == arcaneCraftingInput.height &&
                    this.ingredientCount == arcaneCraftingInput.ingredientCount &&
                    ItemStack.listMatches(this.items, arcaneCraftingInput.items);
        }

        return matches;
    }

    @Override
    public int hashCode()
    {
        int i = ItemStack.hashStackList(this.items);
        i = 31 * i + this.width;
        return 31 * i + this.height;
    }

    public record Positioned(ArcaneCraftingInput input, int left, int top)
    {
        public static final Positioned EMPTY;

        static
        {
            EMPTY = new Positioned(ArcaneCraftingInput.EMPTY, 0, 0);
        }
    }
}
