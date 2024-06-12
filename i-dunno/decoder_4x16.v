`timescale 1ns / 1ps
`include "decoder_3x8.v"
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 12/04/2020 10:55:55 PM
// Design Name: 
// Module Name: decoder_4x16
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


module decoder_4x16(
    input [3:0]xd,// its 4 bit so I decided to use 4 bit bu  I haven't use last bit (8) I dunno why I have decleare like that probably just want to feel good
    input temp_e,
    output [15:0]fd   );
    decoder_3x8 d1(.x(xd[2:0]),.en(temp_e),.f(fd[7:0]));//our d1 object(?) one of the 3x8 otherone in the below
    decoder_3x8 d2(.x(xd[2:0]),.en(~temp_e),.f(fd[15:8]));//our d2 object
endmodule
