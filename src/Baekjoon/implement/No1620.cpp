#include <bits/stdc++.h>
using namespace std;

map<string, int> mp;
string arr[100001];
int N, M;
string s;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> N >> M;
	for(int i = 0; i < N; i++){
		cin >> s;
		mp[s] = i + 1;
		arr[i+1] = s;
	}
	
	// M번 동안 입력받은 값이 숫자 혹은 문자일 때 적절한 값 반환
	for(int i = 0; i < M; i++){
		cin >> s;
		if(atoi(s.c_str()) == 0){
			// 입력이 문자임 -> 숫자 반환(map 자료구조 사용) 
			cout << mp[s] << "\n"; 
		} else {
			cout << arr[atoi(s.c_str())] << "\n";
		}
	} 

	return 0;
}
