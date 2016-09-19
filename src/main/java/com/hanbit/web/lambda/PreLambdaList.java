package com.hanbit.web.lambda;

import java.util.Arrays;
import java.util.List;

public class PreLambdaList {
	public static void main(String[] args) {
		PreLambdaList p = new PreLambdaList();
		p.printElem();
		System.out.println("\n전체 합계 : " + p.sumAll());
		System.out.println("짝수 합계 : " + p.sumEven());
		System.out.println("홀수 합계 : " + p.sumOdd());
	}
	
	List<Integer> numbers = Arrays.asList(1,2,3,4,5);
	public void printElem() {
		for(int num : numbers) {
			System.out.print(num + " ");
		}
	}
	public int sumAll(){
		int sum = 0;
		for(int num : numbers){
			sum += num;
		}
		return sum;
	}
	
	public int sumEven(){
		int sum = 0;
		for(int num : numbers){
			if(num % 2 == 0)
				sum += num;
		}
		return sum;
	}
	
	public int sumOdd(){
		int sum = 0;
		for(int num : numbers){
			if(num % 2 == 1)
				sum += num;
		}
		return sum;
	}
}
