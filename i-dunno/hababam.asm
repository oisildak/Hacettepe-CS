

	
	.data
A: 	.word 720, 480, 80, 3, 1, 0
	.text
	.globl main

main:
	la 	$a0, A			# a0 -> In here we initialize the array
	add 	$s1, $0, $0		# like a c code we initialize int i for loop
	addi 	$s2, $0, 6		# In here we are setting the  bounding 	
					
for:
	bge 	$s1, $s2, print	# while i<the bounding , the loop keeps running
	lw 	$s3, 0($a0)		# s3 is keeping the array's value  and We are loading the integer from the array 
	
	andi 	$t0, $s3, 1		# We are saving A[s3] to temp value
	
	beq 	$t0, $0, ifeven		# if temp value equal to 0 it would be even else it's odd
	j 		ifodd			

ifeven:
	srl 	$s3, $s3, 3		# In order to divide 8, we are shifting with 3 so it turns 1000 to 0001 
	sw 		$s3, 0($a0)		
	addi 	$s1, $s1, 1		# i++
	addi 	$a0, $a0, 4		# in here we are switching value to the next value of the array
	j 	for				# its turning to for loop

ifodd:
	 
	addi 	$t1, $s3, 0		
	sll	$s3, $s3, 2		# shift to the left, meaning x4
	add 	$s3, $s3, $t1	

	sw 	$s3, 0($a0)		# We are replacing old value with the new value at the array	
	addi	$s1, $s1, 1		# i++
	addi 	$a0, $a0, 4		# in here we are switching value to the next value of the array
	j 	for				# its turning to for loop

print:
	j 	done			
done:						# In here we are exiting from program
	li 	$v0, 10
	syscall
#------------------------------------------------------------------------------------
