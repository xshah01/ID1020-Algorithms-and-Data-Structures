// iterative.c
// Created by Shadab Ahmed on 2020-09-05.
// Copyright © 2020 Shadab Ahmed. All rights reserved.

#include <stdio.h>
#include <string.h>

void iterative() {
    
    char string[100];                                         // fixed max lenght
    
    scanf ("%s", string);                                     // scan input and store in string
    
    int len = strlen(string);                                 // calculate the lenght of string
    
    for (int i=len-1; i>=0; i--) {                            // go through str starting from the last index
        printf("%c", string[i]);                              // print characters
    }
}
    
int main() {
    
    printf ("Enter sentence: ");
    iterative();                                              // the function iterative() is called
    printf("\n\n");
    
}
