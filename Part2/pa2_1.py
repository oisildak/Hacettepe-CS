import cv2.cv2 as cv2
from pa2_2 import *

img = cv2.imread("scotland_house.jpg")
img = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)

img2 = cv2.imread("scotland_plain.jpg")
img2 = cv2.cvtColor(img2, cv2.COLOR_BGR2RGB)

'''
This is converting the image to LMS space.
'''
def ConvertLMS(target, ConvertMatrix=first_ConvertMatrix):
    after_ConvertMatrix = np.zeros(target.shape, dtype=np.uint8)
    for x in range(target.shape[0]):
        for y in range(target.shape[1]):
            after_ConvertMatrix[x, y] = np.dot(ConvertMatrix, target[x, y])
            if after_ConvertMatrix[x, y][0] == 0:
                after_ConvertMatrix[x, y][0] = 1
            if after_ConvertMatrix[x, y][1] == 0:
                after_ConvertMatrix[x, y][1] = 1
            if after_ConvertMatrix[x, y][2] == 0:
                after_ConvertMatrix[x, y][2] = 1
            after_ConvertMatrix[x, y] = np.log10(after_ConvertMatrix[x, y])
    return after_ConvertMatrix

'''
For laß space
'''
def lab(target):
    empty_lab = np.zeros(target.shape, dtype=np.float32)
    for x in range(target.shape[0]):
        for y in range(target.shape[1]):
            empty_lab[x, y] = np.dot(second_ConvertMatrix, np.dot(third_ConvertMatrix, target[x, y]))
    return empty_lab

'''
calling functions
'''
source = lab(ConvertLMS(img.copy()).copy())
target = lab(ConvertLMS(img2.copy()).copy())
result = colorTransfer(source, target)

img = cv2.cvtColor(img, cv2.COLOR_RGB2BGR)
img2 = cv2.cvtColor(img2, cv2.COLOR_RGB2BGR)
result = cv2.cvtColor(result, cv2.COLOR_RGB2BGR)
cv2.imshow("source", img)
cv2.imshow("target", img2)
cv2.imshow("result", result)
cv2.waitKey(0)
