import numpy as np
import math
'''
Matrixes for multiplication
'''
first_ConvertMatrix = np.array([[0.3881, 0.5783, 0.0402], [0.1967, 0.7244, 0.0782], [0.0241, 0.1288, 0.8444]])
second_ConvertMatrix = np.array([[1 / math.sqrt(3), 0, 0], [0, 1 / math.sqrt(6), 0], [0, 0, 1 / math.sqrt(2)]])
third_ConvertMatrix = np.array([[1, 1, 1], [1, 1, -2], [1, -1, 0]])
fourth_ConvertMatrix = np.array([[4.4679, -3.5873, 0.1193], [-1.2186, 2.3809, -0.1624], [0.0497, -0.2439, 1.2045]])
five_convertMatrix = np.array([[math.sqrt(3) / 3, 0, 0], [0, math.sqrt(6) / 6, 0], [0, 0, math.sqrt(2) / 2]])
six_convertMatrix = np.array([[1, 1, 1], [1, 1, -1], [1, -2, 0]])


'''
Color Transform algorithm it returns the final image.

'''
def colorTransfer(source, target):
    l_mean, a_mean, b_mean, l_var, a_var, b_var = MeanCal(source)
    lt_mean, at_mean, bt_mean, lt_var, at_var, bt_var = MeanCal(target)
    empty_lms = np.zeros(source.shape, dtype=np.uint8)
    result = np.zeros(source.shape, dtype=np.uint8)
    for x in range(source.shape[0]):
        for y in range(source.shape[1]):
            source[x, y][0] = ((source[x, y][0] - l_mean) * (lt_var / l_var)) + lt_mean
            source[x, y][1] = ((source[x, y][1] - a_mean) * (at_var / a_var)) + at_mean
            source[x, y][2] = ((source[x, y][2] - b_mean) * (bt_var / b_var)) + bt_mean
    for x in range(source.shape[0]):
        for y in range(source.shape[1]):
            empty_lms[x, y] = MaxAndMin(np.dot(six_convertMatrix, np.dot(five_convertMatrix, source[x, y])))
    for x in range(empty_lms.shape[0]):
        for y in range(empty_lms.shape[1]):
            empty_lms[x, y][0] = 10 ** empty_lms[x, y][0]
            empty_lms[x, y][1] = 10 ** empty_lms[x, y][1]
            empty_lms[x, y][2] = 10 ** empty_lms[x, y][2]
    for x in range(empty_lms.shape[0]):
        for y in range(empty_lms.shape[1]):
            result[x, y] = MaxAndMin(np.round(np.dot(fourth_ConvertMatrix, empty_lms[x, y])))
    return result

'''

for bounding the values of the image
'''
def MaxAndMin(v):
    if v[0] < 0:
        v[0] = 1
    if v[1] < 0:
        v[1] = 1
    if v[2] < 0:
        v[2] = 1
    if v[0] > 255:
        v[0] = 255
    if v[1] > 255:
        v[1] = 255
    if v[2] > 255:
        v[2] = 255
    return v

'''
This calculates the mean and variance of the image
'''

def MeanCal(matrix):
    l = []
    a = []
    b = []
    for x in range(matrix.shape[0]):
        for y in range(matrix.shape[1]):
            l.append(matrix[x, y][0])
            a.append(matrix[x, y][1])
            b.append(matrix[x, y][2])
    l_mean = np.mean(l)
    a_mean = np.mean(a)
    b_mean = np.mean(b)

    l_var = np.var(l)
    a_var = np.var(a)
    b_var = np.var(b)
    return l_mean, a_mean, b_mean, l_var, a_var, b_var
