import numpy as np

'''
Max-Min holds the pixel 0-255 value of the image
if it is greater than the 255 value, it is set to 255
if it is less than the 0 value, it is set to 0
'''
def MaxAndMin(v):
    if v > 255:
        v = 255
    if v < 0:
        v = 0
    return v

'''
I have used to Floyd-Steinberg dithering algorithm over the image 
new pixel value is quantized value with round then I calculate the error

'''
def FloydSteinberg(image, q):
    row = image.shape[0]
    col = image.shape[1]

    for i in range(1, row - 1):
        for j in range(1, col - 1):
            oldpixel = image[i, j]
            newpixel = np.round(float(oldpixel) / (255/q))*(255/q)
            image[i, j] = newpixel

            quant_error = oldpixel - newpixel

            image[i + 1, j] = MaxAndMin(image[i + 1, j] + quant_error * 7 / 16.0)
            image[i - 1, j + 1] = MaxAndMin(image[i - 1, j + 1] + quant_error * 3 / 16.0)
            image[i, j + 1] = MaxAndMin(image[i, j + 1] + quant_error * 5 / 16.0)
            image[i + 1, j + 1] = MaxAndMin(image[i + 1, j + 1] + quant_error * 1 / 16.0)

    return image
