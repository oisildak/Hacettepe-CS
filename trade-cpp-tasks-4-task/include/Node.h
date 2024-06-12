//
// Created by joi on 11.03.2024.
//

#ifndef NODE_H
#define NODE_H
struct Node {
    int data;
    struct Node *next;
};
void delete_with_position(Node** head,int position);
#endif //NODE_H
