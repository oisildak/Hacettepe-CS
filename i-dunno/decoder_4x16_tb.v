`timescale 1ns / 1ps
`include "decoder_4x16.v"

//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 12/04/2020 11:18:41 PM
// Design Name: 
// Module Name: decoder_4x16_tb
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////


module decoder_4x16_tb;
    reg [3:0] input_stimulite;// I have gave 4 bit because its takes 4 bit 4x16
    integer i;
    reg test_en;
    wire [15:0]output_f;//it takes 16 output 
    decoder_4x16 UTR(.xd(input_stimulite),.temp_e(test_en),.fd(output_f));//our object(?)
    initial
        begin
        input_stimulite=4'b0000;// I am an amele :( 
        test_en=1'b1;
        for(i=0;i<8;i=i+1)//After that starting with enable 0 
            #40 
            input_stimulite=input_stimulite +1;
        input_stimulite=4'b0000;
        test_en=1'b0;
        #40
        input_stimulite=input_stimulite +1;
        #40
        input_stimulite=input_stimulite +1;
        #40
        input_stimulite=input_stimulite +1;
        #40
        input_stimulite=input_stimulite +1;
        #40
        input_stimulite=input_stimulite +1;
        #40
        input_stimulite=input_stimulite +1;
        #40
        input_stimulite=input_stimulite +1;

    end
endmodule
