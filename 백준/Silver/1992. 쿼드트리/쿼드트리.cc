#include <bits/stdc++.h>
using namespace std;

int N;
char arr[64][64];
string s;

string go(int size, int y, int x){
	if(size == 1) return string(1,arr[y][x]);
	
	char b = arr[y][x];
	
	for(int i = y; i < y + size; i++){
		for(int j = x; j < x + size; j++){
			if(b != arr[i][j]){
				string ret = "";
				ret += "(";
				ret += go(size/2, y, x);
				ret += go(size/2, y, x + size/2);
				ret += go(size/2, y + size/2, x);
				ret += go(size/2, y + size/2, x + size/2);
				ret += ")";
				
				return ret;
			}
		}
	}
	
	return string(1, arr[y][x]);
}


int main(){
	
	cin >> N;
	for(int i = 0; i < N; i++){
		cin >> s;
		for(int j = 0; j < N; j++){
			arr[i][j] = s[j];
		}
	}
	
	cout << go(N, 0, 0) << "\n";

	return 0;
}