import cv2.cv2 as cv
import numpy as np

from p1_2 import FloydSteinberg

'''
if you want to calculate q parameter, you should either (2**q)-1 or
you can directly use the value of calculated q.

I have used calculated q.


Also you should read image with cv2.imread() not from console.


'''

img= cv.imread('1.png')

img= cv.cvtColor(img, cv.COLOR_BGRA2GRAY)
cv.imshow("Source ", img)

iq=np.array(img)
'''
its iterate over the image and apply the quantization algorithm
then its called the dithering algorithm
which is at the py2_1.py

'''
for x in range(img.shape[0]):
    for y in range(img.shape[1]):
        iq[x,y]=np.round(img[x,y]/(255/1))*(255/1)
cv.imshow("quantized",iq)


dithered=(FloydSteinberg(img, 1))
cv.imshow("Dithered",dithered)

cv.waitKey(0)