package com.lordskittles.seidra.common.registries;

import api.lordskittles.seidra.common.registry.DeferredSchool;
import api.lordskittles.seidra.common.registry.SeidraRegistries;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.sai.schools.TestSchool;

public class Schools
{
	public static final SeidraRegistries.Schools SCHOOLS = SeidraRegistries.createSchools(Seidra.MODID);

	public static final DeferredSchool<TestSchool> TEST_SCHOOL = SCHOOLS.register("test_school", TestSchool::new);
}
