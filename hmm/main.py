import cv2.cv2 as cv2
import numpy as np

img1=cv2.imread("building1.jpg")
img2=cv2.imread("building2.jpg")
img3=cv2.imread("building3.jpg")

#sift
sift=cv2.SIFT_create()
img1=cv2.pyrDown(img1,6)
img2=cv2.pyrDown(img2,6)
img3=cv2.pyrDown(img3,6)
kp1,des1=sift.detectAndCompute(img1,None)
kp2,des2=sift.detectAndCompute(img2,None)
kp3,des3=sift.detectAndCompute(img3,None)
sift_img1=cv2.drawKeypoints(img1,kp1,None)
sift_img2=cv2.drawKeypoints(img2,kp2,None)
sift_img3=cv2.drawKeypoints(img3,kp3,None)

bf=cv2.BFMatcher()
matches=bf.knnMatch(des1,des2,k=2)


limit=[]
for m,n in matches:
    if m.distance<(0.5*n.distance):
        limit.append([m])
corners1=[img1[0][0],img1[0][-1],img1[-1][0],img1[-1][-1]]
corners2=[img2[0][0],img2[0][-1],img2[-1][0],img2[-1][-1]]



homography,status=cv2.findHomography(np.float32(corners1),np.float32(corners2),cv2.RANSAC)

img_1_2 = cv2.drawMatchesKnn(img1,kp1,img2,kp2,limit,flags=2,outImg=None)

img_2_3 = cv2.drawMatchesKnn(img2,kp2,img3,kp3,limit,flags=2,outImg=None)
result=cv2.warpPerspective(img_2_3,homography,(img_2_3.shape[1],img_2_3.shape[0]))

cv2.imshow("sift_img1",img_1_2)
cv2.imshow("sift_img2",img_2_3)

cv2.waitKey(0)
