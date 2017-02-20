package com.juzi;

import java.io.File;

public final class Constant {

	private static final String data_dir = "algs4-data";

	public static final String getParentPath() {
		String workingDir = System.getProperty("user.dir");
		File workingPath = new File(workingDir);
		String parentPath = workingPath.getParent();
		return new File(parentPath, data_dir).getPath() + File.separatorChar;
	}

	public static void main(String[] args) {
		System.out.println(getParentPath());
	}
}
