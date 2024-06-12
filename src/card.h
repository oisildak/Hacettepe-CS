struct card
{
    std::string fullNameOfCard;
    bool flag=true;
    char typeOfCard;
    int number=-1;
    card();
    card(std::string fullNameOfCard,char name,int number);
    ~card();
};

card::card()
{
}

card::~card()
{
}
card::card(std::string fullNameOfCard,char typeOfCard,int number){
    this->fullNameOfCard=fullNameOfCard;
    this->typeOfCard=typeOfCard;
    this->number=number;
}