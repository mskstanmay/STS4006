Given an array of prices of a stock on n days

find profit span

for each index, compare with previous indexes and in new array keep values of which is higher than others

&nbsp;	for the first stock price is always 1

&nbsp;	if current >=  prev increment by 1 until it reaches a  value on left which is greater

&nbsp;	if prev > current = return current value ( default 1 )



example: \[60,70,100,90,110,90]



we get 



\[1,2,3,1,5,1]



1. 60 is 1 as first price
2. compare 60 \& 70, 1+1 = 2
3. compare 100 \& 70, 100 \& 60 = 1+1+1 = 3
4. compare 90 \& 100 = 1
5. compare 110 with all elements before = 1+1+1+1+1 = 5
6. compare 90 \& 110 = 1



\[60,50,70,40,80,100] = \[1,1,3,1,5,6]



Intuition: In a stack, send value for each stock representing how many it is higher than on its left

-- if any such element is found on left simply do i+1 



\[60,50,70,40,80,100] 

* if stack is not empty compare values, find span based on formula for empty or non empty stack
* if stack is empty find span values
* set span = i+1 // for empty stack
* so for i = 0, span = \[1]
* send index position inside the stack
* as stack is not empty compare with previous value 60 \& 50
* now find span value  span = i - stack.peek(); // for non empty stack
* push 1 into stack
