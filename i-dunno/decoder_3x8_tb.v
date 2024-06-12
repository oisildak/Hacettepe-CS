`timescale 1ns / 1ps
`include "decoder_3x8.v"
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 12/04/2020 10:42:04 PM
// Design Name: 
// Module Name: decoder_3x8_tb
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


module decoder_3x8_tb;

    reg [2:0] input_stimulite;// it takes 3 input
    integer i;// just we need for loop so I have to deckleare
    reg test_en;//enable bit
    wire [7:0] output_f;//our output it takes 8 
    decoder_3x8 UTT(.en(test_en),.x(input_stimulite),.f(output_f));//our object
    initial
        begin
        input_stimulite=3'b000;//just for one case after that we turn it to 1
        test_en=1'b0;
        #100
        test_en=1'b1;
        
        for(i=0;i<8;i=i+1)
            #100 
            input_stimulite=input_stimulite +1;
    end
endmodule


