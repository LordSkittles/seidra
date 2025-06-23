package com.lordskittles.seidra.common.registries;

import api.lordskittles.seidra.common.registry.DeferredSchool;
import api.lordskittles.seidra.common.registry.SeidraRegistries;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.sai.schools.*;

public class Schools
{
	public static final SeidraRegistries.Schools SCHOOLS = SeidraRegistries.createSchools(Seidra.MODID);

	public static final DeferredSchool<DeepcallingSchool> DEEPCALLING = SCHOOLS.register("deepcalling", DeepcallingSchool::new);
	public static final DeferredSchool<EmbercraftSchool> EMBERCRAFT = SCHOOLS.register("embercraft", EmbercraftSchool::new);
	public static final DeferredSchool<FrostweavingSchool> FROSTWEAVING = SCHOOLS.register("frostweaving", FrostweavingSchool::new);
	public static final DeferredSchool<SkyrendSchool> SKYREND = SCHOOLS.register("skyrend", SkyrendSchool::new);
	public static final DeferredSchool<SpiritguardSchool> SPIRITGUARD = SCHOOLS.register("spiritguard", SpiritguardSchool::new);
	public static final DeferredSchool<FellwakeSchool> FELLWAKE = SCHOOLS.register("fellwake", FellwakeSchool::new);
}
