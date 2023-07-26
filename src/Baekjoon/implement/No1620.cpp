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
	
	// M�� ���� �Է¹��� ���� ���� Ȥ�� ������ �� ������ �� ��ȯ
	for(int i = 0; i < M; i++){
		cin >> s;
		if(atoi(s.c_str()) == 0){
			// �Է��� ������ -> ���� ��ȯ(map �ڷᱸ�� ���) 
			cout << mp[s] << "\n"; 
		} else {
			cout << arr[atoi(s.c_str())] << "\n";
		}
	} 

	return 0;
}
