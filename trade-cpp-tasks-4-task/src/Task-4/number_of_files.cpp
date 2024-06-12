//
// Created by joi on 11.03.2024.
//
#include <filesystem>
#include <atomic>
#include <fstream>
#include <iostream>
#include <thread>
#include <vector>



std::atomic<int> totalLines=0;

void countLines(const std::filesystem::path& filePath) {
    std::ifstream file(filePath);
    std::string line;
    int lines=0;
    while (std::getline(file,line)) {
        lines++;
    }
    totalLines+=lines;
}

void numberOfLines(const std::filesystem::path& dirpath) {
    std::vector<std::filesystem::path> files;
    for(const auto entry: std::filesystem::directory_iterator(dirpath)) {
        files.push_back(entry.path());
    }
    const size_t cores=std::thread::hardware_concurrency();
    std::vector<std::thread> threads;

    for (auto& file: files) {
        if (threads.size()==cores) {
            for (std::thread& t: threads) {
                if (t.joinable()) {
                    t.join();
                }
            }
            threads.clear();
        }
        threads.emplace_back(countLines,file);
    }
    for (std::thread& t:threads) {
        if (t.joinable()) {
            t.join();
        }
    }

}

void test_threads(std::string address) {
    std::cout << "Task-4 Test is starting\n";
    std::filesystem::path paths(address);
    if (!std::filesystem::exists(paths)) {
        std::cout << "Path not valid!!!\nTask-4 Test's Failed"<<std::endl;
        return;
    }
    numberOfLines(paths);
    std::cout << "Total Lines: "<<totalLines<<std::endl ;
    std::cout << "Task-4 Test is finished\n";

}
