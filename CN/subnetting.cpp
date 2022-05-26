#include <iostream>
#include <sstream>
#include <cmath>
using namespace std;
int main()
{
    string ip;
    cout << "\nEnter the IP address: ";
    cin >> ip;
    int i = 0;
    
    //extracting 1st octat from ipaddress
    while (ip[i] != '.')
        i++;
    string clas = ip.substr(0, i);
    stringstream a(clas);
    int ip_1 = 0;
    a >> ip_1;
    i = 0;
    
    //checking class of ipaddress {A<=127,B>=192,C>=224}
    if (128 <= ip_1)
        i++;
    if (ip_1 >= 192)
        i++;
    if (ip_1 >= 224)
        i++;
    int cl = i;

    //getting maximum number of subnets according to class
    int max = pow(pow(2, 8), 3 - i);
    int subnet = 0;
    cout << "\nEnter the no. of subnet max(" << max - 2 << "):";
    cin >> subnet;

    //error handling
    while (subnet > max - 2)
    {
        cout << "\nEnter a valid no. of subnets: ";
        cin >> subnet;
    }

    char c = 'A' + i;
    cout << "\nClass of IP address is " << c;

    //default subnet
    int default_sub[4];
    int j = 0;
    for (j = 0; j <= i; j++)
        default_sub[j] = 255;
    for (j = i + 1; j < 4; j++)
        default_sub[j] = 0;
    cout << "\nDefault subnet mask: ";
    for (j = 0; j < 4; j++)
    {
        cout << default_sub[j] << ".";
    }

    //subnet mask
    int subnet_mask[4];
    for (j = 0; j < 4; j++)
    {
        subnet_mask[j] = default_sub[j];
    }
    j = 0;
    while (pow(2, j) < subnet)
    {
        j++;
    }
    int sub2 = subnet;
    subnet = pow(2, j);
    j = i;
    while (subnet > 256)
    {
        i++;
        subnet_mask[i] = 255;
        subnet /= 256;
    }
    subnet_mask[i + 1] = 256 - 256 / subnet;
    cout << "\nsubnet mask =";
    for (j = 0; j < 4; j++)
    {
        cout << subnet_mask[j] << ".";
    }
    int k = 1;
    cout << endl;
    int add = (256 / subnet);

    //subnetting
    while (k <= sub2)
    {
        cout << "\nSubent " << k << " Range = ";
        for (j = 0; j < 4; j++)
        {
            cout << default_sub[j] << ".";
        }
        default_sub[i + 1] += add;
        if (default_sub[i + 1] == 256)
        {
            default_sub[i]++;
            default_sub[i + 1] = 0;
            if (default_sub[i] > 256)
            {
                default_sub[i - 1]++;
                default_sub[i] -= 256;
            }
        }
        cout << " to ";
        for (j = 0; j < 4; j++)
        {
            if (j == cl + 1)
                cout << default_sub[j] - 1 << ".";
            else
                cout << default_sub[j] << ".";
        }
        k++;
    }
    return 0;
}
