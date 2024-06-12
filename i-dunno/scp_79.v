`timescale 1ns / 1ps
/* 
This code doesn't work properly sorry for that hocam :( I could't figure out how to fix it and where is my mistakes. I apologize for disappointing you.
:'(
*/


module scp_79(clk,g,y,r,a1,a2,a3,cheat_out);
    input clk,g,y,r;
    integer  timer;
    reg[3:0] state;
    reg[3:0] next_state;
    
    output reg a1,a2,a3,cheat_out;
    localparam s0=3'b000, s1=3'b001,//parameters
               s2=3'b010,s3=3'b011,
               s4=3'b100,s5=3'b101;
    always @(posedge clk)
        state<=next_state;       
    always @(posedge g)
        case(state)//states  there is bunch of if else blocks
            s0: if(g==1) begin
                    a1<=1;                     
                    next_state<=s2;  end
                else if(r==1) begin
                    next_state<=s0; a1<=0; a2<=0; a3<=0; cheat_out<=1; end
                else begin
                   next_state<=s1;a1<=0; a2<=0; a3<=0; cheat_out<=0; end
            s1:   if(r==1)begin
                    next_state<=s4;
                    end 
                    else begin
                    next_state<=s0;a1<=0; a2<=0; a3<=0; cheat_out<=0;
                        end
           s2: if(g==1) begin
                a2<=1;
                next_state<=s3;
                end
           s3: if(g==1)begin
                 a3<=1; 
                 next_state<=s5;         
                end 
            s5: 
                begin
                    a1<=1; a2<=1; a3<=1; cheat_out<=0;
                    end                                 
          endcase
      
       
            
endmodule
