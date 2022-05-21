#include <stdio.h>
#include <math.h>
int binToDeci(int array[4])
{
    int digit = 0;
    for (int i = 0; i < 4; i++)
    {
        if (array[i] == 1)
        {
            digit += pow(2, i);
        }
    }
    return digit;
}
int deciToBin(int num, int check)
{
    int binary[4] = {0};
    for (int i = 0; i < 4; i++)
    {
        binary[i] = num % 2;
        num = num / 2;
    }
    if (binary[check] == 1)
    {
        return binToDeci(binary);
    }
    else
    {
        return -1;
    }
}
int getPositions(int rbit, int size, int positions[30])
{
    int k = 0;
    for (int i = 0; i < size; i++)
    {
        int check = -1;
        check = deciToBin(i, rbit);
        if (check != -1)
        {
            positions[k] = check;
            k++;
        }
    }
    return k;
}
int rbitCal(int Msize)
{
    int num = 0;
    while ((pow(2, num) < num + Msize + 1))
    {
        num++;
    }
    return num;
}
void setRbit(int codedSize, int codedMessage[])
{
    int tpos = 0;
    printf("\n");
    for (int i = 1; i < codedSize; i++)
    {
        if (i == pow(2, tpos))
        {
            int positions[codedSize] = {0};
            int psize = getPositions(tpos, codedSize, positions);
            printf("\n");
            int sum = 0;
            for (int j = 0; j < psize; j++)
            {
                sum += codedMessage[positions[j]];
            }
            sum = sum % 2;
            int k = pow(2, tpos);
            codedMessage[k] = sum;
            tpos += 1;
        }
    }
}
int checkMessage(int codedSize, int rbitSize, int reciMessage[])
{
    int rbits[rbitSize] = {0};
    setRbit(codedSize, reciMessage);
    for (int i = 1; i < codedSize; i++)
    {
        printf("%d", reciMessage[i]);
    }
    int pos = 0, index = 0;
    for (int i = 1; i < codedSize; i++)
    {
        if (i == pow(2, pos))
        {
            rbits[index] = reciMessage[i];
            index++;
            pos++;
        }
    }
    int t = binToDeci(rbits);
    return t;
}
int main()
{
    int Msize = 0;
    printf("\nEnter Length of message : ");
    scanf("%d", &Msize);
    int message[Msize] = {0};
    printf("\nEnter message from lowest bit : ");
    for (int i = 0; i < Msize; i++)
    {
        printf("\nEnter the bit %d : ", i);
        scanf("%d", &message[i]);
    }
    for (int i = 0; i < Msize; i++)
    {
        printf("%d", message[i]);
    }


    // Find number of Rbits
    int rbitSize = rbitCal(Msize);
    int codedSize = Msize + rbitSize + 1;
    int codedMessage[codedSize] = {0};
    
    
    // Coded = Rbit + Message
    int index = 0, pos = 0;
    for (int i = 1; i < codedSize; i++)
    {
        if (i == pow(2, pos))
        {
            codedMessage[i] = 0;
            pos++;
        }
        else
        {
            codedMessage[i] = message[index];
            index += 1;
        }
    }
   


    // Getting The Rbit Values in Senders Side;
    setRbit(codedSize, codedMessage);
   
    printf("\nFinal Coded Message : ");
    for (int i = 1; i < codedSize; i++)
    {
        printf("%d", codedMessage[i]);
    }
    


    // RECEIVER SIDE//
    int Rmessage[codedSize] = {0};
    int correction[rbitSize] = {0};
    printf("\nEnter Received String\n");
    for (int i = 1; i < codedSize; i++)
    {
        printf("Enter the %d bit :", i);
        scanf("%d", &Rmessage[i]);
    }
    int Flag = checkMessage(codedSize, rbitSize, Rmessage);
    if (Flag == 0)
    {
        printf("\nCorrect Message Received ");
    }
    else
    {
        printf("\nIncorrect Message Received \nError is at the position %d", Flag);
    }
    return 0;
}
