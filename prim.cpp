
#include <iostream>
#include <vector>
using namespace std;

//用邻接矩阵表示无向图
#define N 6 //节点个数
#define M 100000//最大值，表示不可达
int matrix[N][N]=
{
    M,3,M,M,6,5,
    3,M,1,M,M,4,
    M,1,M,6,M,4,
    M,M,6,M,8,5,
    6,M,M,8,M,2,
    5,4,4,5,2,M
};

void prim()
{
    //记当前生成树的节点集合为S
    //未使用的节点结合为V
    bool flag[N]; //标记某个点是否在S中
    int nearest[N]; //记录V中每个点到S中邻接点的最短边
    int adjecent[N];//记录与V中每个点最邻接近的点
    int i,j,min;
    //初始化集合
    for(i = 0; i < N; ++i) flag[i] = false;

    flag[0] = true;
    for(i = 1; i < N; ++i)
    {
        nearest[i] = matrix[0][i];
        adjecent[i] = 0;
    }
    int count = N;
    while(--count)
    {
        min = M;
        j = 0;
        for(i = 0; i < N; ++i)
        {
            if(!flag[i] && nearest[i] < min)
            {
                min = nearest[i];
                j = i;
            }
        }

        cout << j + 1 << "-" << adjecent[j] + 1 << " " << matrix[j][adjecent[j]] << endl;

        flag[j] = true;

        for(i = 0; i < N; ++i)
        {
            if(!flag[i] && matrix[i][j] < nearest[i])
            {
                nearest[i] = matrix[i][j];
                adjecent[i] = j;
            }
        }
    }
}

int main(int argc, char* *argv)
{
    prim();
    //system("pause");
    return 0;
}
