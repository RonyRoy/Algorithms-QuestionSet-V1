package com.example.assignment2.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArrayInput {
	@JsonProperty(value = "arr")
	private int[] arr;

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

}

