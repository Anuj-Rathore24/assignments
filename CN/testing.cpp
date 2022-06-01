#include<iostream>
#include<sstream>

using namespace std;

int main(){
    string ip,octet;
    cout<<"Enter Ip address ->";
    cin>>ip;
    int first_octet,i=0,n=0;
    while(!ip[i]=='.'){
        octet+=ip[i];
        i++;
    }
    stringstream geek(octet);
    geek>>first_octet;

    
    if(first_octet<=128){
        n++;
    }
    if(first_octet>=192){
        n++;
    }
    if(first_octet>=224){
        n++;
    }

    int subnets;
    cout<<"The class of ip address is ->"<<'A'+n;
    cout<<"Enter Number of subnets ->";
    cin>>subnets;

    int default_subnetMask[4],subnetMask[4];
    for(int i=0;i<4;i++){
        if(i<=n){
            default_subnetMask[i]=225;
            subnetMask[i]=225;
        }else{
            default_subnetMask[i]=0;
            subnetMask[i]=0;
        }
    }


    return 0;
}