#include <bits/stdc++.h>
using namespace std;

int inorderArr[100000];
int postorderArr[100000];

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
	
	// 전위 탐색으로 출력 (루트 -> 왼쪽 -> 오른쪽) 
	cout << root << " ";
	DFS(start1, rootIndex - 1, start2, start2 + leftCount - 1); // 루트를 기준으로 왼쪽 영역에 대해 탐색 (Inorder 범위 및 Postorder 범위 지정) 
	DFS(rootIndex + 1, end1, start2 + leftCount, end2 - 1); // // 루트를 기준으로 오른쪽 영역에 대해 탐색 (Inorder 범위 및 Postorder 범위 지정) 

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
