#include <bits/stdc++.h>
using namespace std;

int inorderArr[100001];
int postorderArr[100001];

void DFS(int start1, int end1, int start2, int end2){
	if (start1 > end1 || start2 > end2) return;
	
	int root = postorderArr[end2];
	int rootIndex = -1; // 중위 표기법의 루트 인덱스 
	for(int i = start1; i <= end1; i++){
		if (inorderArr[i] == root){
			rootIndex = i;
			break;
		}
	}
	
	int leftCount = rootIndex - start1;
	
	cout << root << " ";
	DFS(start1, rootIndex - 1, start2, start2 + leftCount - 1);
	DFS(rootIndex + 1, end1, start2 + leftCount, end2 - 1);

}

int main(){
	
	int n;
	cin >> n; // cin >> n >> '\n' (X)
	
	for(int i = 0; i < n; i++){
		cin >> inorderArr[i];
	}
	
	for(int i = 0; i < n; i++){
		cin >> postorderArr[i];
	} 	

	DFS(0,n-1,0,n-1);
	
	return 0;
}
