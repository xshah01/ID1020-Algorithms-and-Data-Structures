//  Assignment 1
//  RemoveNonChar.c
//  Created by Shadab Ahmed on 2020-09-24.
//  Copyright © 2020 Shadab Ahmed. All rights reserved.

#include <stdio.h>
#include <ctype.h>

int main() {
    
    /*
      Read and write the textfile.
    */
    FILE *input, *output;
    input = fopen("/Users/shadabahmed/Desktop/test.txt", "r");
    output = fopen("/Users/shadabahmed/Desktop/test1.txt", "w");
    
    /*
      isalpha() checks if the charachter is an alphabet or not. For every non-alphabetic
      character, a blank space will be written to that char.
    */
    char c;
    while ((c = getc(input)) != EOF) {
        
        if (!isalpha(c) && c != ' ' && c != '\n') {
            c = ' ';
        }
        
        fputc(c,output);
    }
    
    fclose(input);
    fclose(output);
    
    return 0;
}
