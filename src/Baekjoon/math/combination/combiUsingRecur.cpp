#include <bits/stdc++.h>
using namespace std;

int n = 5, k = 3, a[5] = {1,2,3,4,5};
void print(vector<int> b){
	for(int i : b) cout << i << " ";
	cout << "\n";
}
void combi(int start, vector<int> b){
	
	// 동적 배열 vector에 값을 차례대로 집어 넣는 방식으로 조합을 생성 -> 크기 다 차면 출력 
	if(b.size() == k){
		print(b);
		return ;
	}
	for(int i = start + 1; i < n; i ++){
		b.push_back(i); // 호출된 인자의 다음 수부터 삽입 가능 
		combi(i, b); // 삽입한 값 다음 수부터 다시 삽입 
		b.pop_back(); // 함수 출력이 끝났을 경우, 값을 다시 제거 
	}
	return ;
}

int main(){
	vector<int> b;
	combi(-1, b);
	return 0;

}
