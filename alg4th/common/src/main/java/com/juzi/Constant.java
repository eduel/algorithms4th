package com.juzi;

import java.io.File;

public final class Constant {

	private static final String data_dir = "algs4-data";

	public static final String getFilePath() {
		String workingDir = System.getProperty("user.dir");
		File workingPath = new File(workingDir);
		String parentPath = workingPath.getParent();
		return new File(parentPath, data_dir).getPath();
	}
}
