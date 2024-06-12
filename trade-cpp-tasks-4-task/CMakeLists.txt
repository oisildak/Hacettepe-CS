cmake_minimum_required(VERSION 3.28)
project(Bull_Trading_Tasks)

set(CMAKE_CXX_STANDARD 17)
include_directories(include)
source_group(src)
add_executable(Bull_Trading_Tasks main.cpp
        src/Task-1/Update_Values.cpp
        include/update.h
        include/Node.h
        src/Task-2/delete_linkedList_position.cpp
        include/smallest.h
        src/Task-3/smallest.cpp
        include/numberOfLines.h
        src/Task-4/number_of_files.cpp)
