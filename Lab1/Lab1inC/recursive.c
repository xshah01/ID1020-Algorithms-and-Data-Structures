//  recursive.c
//  Created by Shadab Ahmed on 2020-09-05.
//  Copyright © 2020 Shadab Ahmed. All rights reserved.

#include<stdio.h>

void rec() {
    
    char c;
    
    if ((c = getchar()) != '\n') {                      // if the input is any character other than '\n', the function rec() is                                                       called again.
        rec();
        
        putchar(c);
        
    }

/*
   When a newline character is read, it starts to print using the putchar() function
   which returns to the previous function and print the second last character,
   and so on
*/
    
}


int main() {
    
    printf("Enter a sentence: ");
    rec();                                              // the function rec() is called
    printf("\n\n");
    
}
