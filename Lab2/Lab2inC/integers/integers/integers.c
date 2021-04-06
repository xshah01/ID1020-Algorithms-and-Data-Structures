// integers.c
// Created by Shadab Ahmed on 2020-09-13.
// Copyright © 2020 Shadab Ahmed. All rights reserved.

#include <stdio.h>

/*
 This method traverses the array, and if a negative element is encountered, the negative element swaps
 with the first positive element. It continues likes this until all the elements have been traversed.
*/
int comparison (int arr[], int len) {
    
    int i,j,tmp;
    j = 0;
        
        for(i = 0; i < len; i++) {
            
            if(arr[i] < 0) {
                
                if(i != j) {
                    
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                    
                }
                
                j++;
            }
            
        }
    
    return 0;
}

/*
  Method for printing the array
*/
void print(int arr[], int len) {
    
    for (int i = 0; i < len; i++) {
        printf("%d ", arr[i]);
    }
    
    printf("\n");
    
}

int main() {
    
    int array[] = {1, -5, 10, 72, -1, -7, 0};
    int len = sizeof(array)/sizeof(array[0]);
    printf("Original array: ");
    print(array,len);
    printf("\n");
    comparison(array,len);
    printf("Rearranged array: ");
    print(array,len);
    printf("\n");
    
}
