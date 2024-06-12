//
// Created by joi on 11.03.2024.
//
#include "Node.h"
void delete_with_position(Node** head,int position) {
    if (*head == nullptr) {
        return;
    }
    Node* dummy=*head;
    if (position==0) {
        *head=dummy->next;
        delete dummy;
        return;
    }
    int i=0;
    while (dummy!=nullptr && i<position-1 ) {
        dummy=dummy->next;
    }
    if (dummy==nullptr || dummy->next==nullptr) {
        return;
    }
    Node* next=dummy->next->next;
    delete dummy->next;
    dummy->next=next;

}
