`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 12/04/2020 10:40:46 PM
// Design Name: 
// Module Name: decoder_3x8
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


module decoder_3x8(
    input en,//our beloved enable bit if its 1 its good if its 0 we will get 0
    input [2:0]x,//because it is 3 to 8 decoder so they hold 3 bit  
    output[7:0]f//output to defination there are 8 output 
    );
    assign f[0]= (en & ~x[2] & ~x[1]& ~x[0]);//  000
    assign f[1]= (en & ~x[2] & ~x[1]& x[0]);//  001
    assign f[2]= (en & ~x[2] & x[1]& ~x[0]);//  010
    assign f[3]= (en & ~x[2] & x[1]& x[0]);// 011
    assign f[4]= (en & x[2] & ~x[1]& ~x[0]);// 100
    assign f[5]= (en & x[2] & ~x[1]& x[0]); // 101
    assign f[6]= (en & x[2] & x[1]& ~x[0]); // 110
    assign f[7]= (en & x[2] & x[1]& x[0]);// 111
endmodule
