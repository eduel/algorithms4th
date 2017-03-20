package com.juzi.chapter1_4.support;

import edu.princeton.cs.algs4.Date;

//address use 8byte for x86_64
//address use 4byte for x86
public class Memory {//use 16byte contains reference,gc infomation,syn information etc.
	//primitive type;
	private boolean boolean_use_1byte;
	private char char_use_2byte;
	private short short_use_2byte;
	private int int_use_4byte;
	private long long_use_8byte;
	private float float_use_4byte;
	private double double_use_8byte;
	private byte byte_use_1byte;

	//wrapped type for 64bit computer;n%8==0;
	private Boolean wrapped_boolean_use_16_1_7;//16 for instance,1 for primitive boolean,7 for padding;
	private Character wrapped_character_use_16_2_6;//
	private Short wrapped_short_use_16_2_6;//
	private Integer wrapped_integer_use_16_4_4;//
	private Long wrapped_long_use_16_8;
	private Float wrapped_float_use_16_4_4;
	private Double wrapped_double_use_16_8;
	private Byte wrapped_byte_use_16_1_7;
	
	//string
	private String init_string_use_16_4_4_2n_4_4;//16 for instance,4 for array length(int),4 for padding,2n for char[], for hash,4 for padding;
	private Date date_use_16_12_4;//16 for instance,12 for 3 int,4 for padding;
	
	class Node<T>{
		T t;
		Node<T> next;
	}
	//inner class use 8 more byte;
	private Node<String> node_use_16_8_8_8;//16 for instance,8 for T,8 for next,8 for inner point to outer class instance;

}
