#include<bits/stdc++.h>
using namespace std;

int isnotprime[10010];

int main(){
    for(int i = 2; i <= 10000; i++) {
        if (i == 1) continue;
        for (int j = i+i; j <= 10000; j += i) isnotprime[j] = 1;
    }

    while (1) {
        long double f;
        scanf("%Lf", &f);
        if (f == 0.00) break;
        if (isnotprime[(int)(f*10)] && isnotprime[(int)(f*100)] && isnotprime[(int)(f*1000)]) printf("FALSE\n");
        else printf("TRUE\n");
    }
    
    return 0;
}