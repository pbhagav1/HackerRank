#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

struct edgeDetails{
    int fromNode;
    int toNode;
    int value;
    int usedInCycleInd;
}edgeDetails;

void getGraph(struct edgeDetails edges[]);
void getMaxNegCycle(struct edgeDetails edges[]);
int getStartNode(struct edgeDetails edges[]);
void getMinEdge(struct edgeDetails edges[],int fromNode, int *toNode, int *minEdge);

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
    struct edgeDetails edges[6];
    getGraph(edges);
    getMaxNegCycle(edges);
    return 0;
}

void getGraph(struct edgeDetails edges[6]) {
    int a, b, c, d, e, f;
    int i;
    scanf("%d %d %d %d %d %d", &a, &b, &c, &d, &e, &f);
    for (i = 0; i < 6; i++){
        switch(i){
            case 0:
                edges[i].fromNode = 3;
                edges[i].toNode = 0;
                edges[i].value = a;
                edges[i].usedInCycleInd = 0;
                break;
            case 1:
                edges[i].fromNode = 0;
                edges[i].toNode = 1;
                edges[i].value = b;
                edges[i].usedInCycleInd = 0;
                break;
            case 2:
                edges[i].fromNode = 1;
                edges[i].toNode = 2;
                edges[i].value = c;
                edges[i].usedInCycleInd = 0;
                break;
            case 3:
                edges[i].fromNode = 2;
                edges[i].toNode = 3;
                edges[i].value = d;
                edges[i].usedInCycleInd = 0;
                break;
            case 4:
                edges[i].fromNode = 0;
                edges[i].toNode = 2;
                edges[i].value = e;
                edges[i].usedInCycleInd = 0;
                break;
            case 5:
                edges[i].fromNode = 1;
                edges[i].toNode = 3;
                edges[i].value = f;
                edges[i].usedInCycleInd = 0;
                break;
        }
    }
}

void getMaxNegCycle(struct edgeDetails edges[6]){
    int startNode, fromNode, toNode;
    int edgeVal, edgeSum, cycleCompleteInd;
    char inpchar;
    
    startNode = getStartNode(edges);
    fromNode = startNode;
    cycleCompleteInd = 0;
    edgeSum = 0;

    while(cycleCompleteInd == 0){
        getMinEdge(edges, fromNode, &toNode, &edgeVal);
        edgeSum += edgeVal;
        if (toNode == startNode)
            cycleCompleteInd = 1;
        else
            fromNode = toNode;
    }
    
    printf("\n%d\n", -(edgeSum));
}

int getStartNode(struct edgeDetails edges[6]){
    int i, j;
    int startNode, startNodeVal;
    int nodeEdgeInd, nodeEdgeVal, nodeEdgeSum[4];

    for (i=0; i<4; i++){
        nodeEdgeInd = 0;
        nodeEdgeSum[i] = 0;
        for(j=0; j<6; j++){
            switch(nodeEdgeInd){
                case 0:
                    if (edges[j].fromNode == i){
                        nodeEdgeInd = 1;
                        nodeEdgeVal = edges[j].value;
                        nodeEdgeSum[i] += edges[j].value;
                    }else{
                        if (edges[j].toNode == i){
                            nodeEdgeInd = 2;
                            nodeEdgeVal = edges[j].value;
                            nodeEdgeSum[i] += edges[j].value;
                        }
                    }
                    break;
                case 1:
                    if ((edges[j].fromNode == i) && (edges[j].value < nodeEdgeVal)){
                        nodeEdgeSum[i] -= nodeEdgeVal;
                        nodeEdgeVal = edges[j].value;
                        nodeEdgeSum[i] += nodeEdgeVal;
                    }else{
                        if (edges[j].toNode == i){
                            nodeEdgeSum[i] += edges[j].value;
                        }
                    }
                    break;
                case 2:
                    if ((edges[j].toNode == i) && (edges[j].value < nodeEdgeVal)){
                        nodeEdgeSum[i] -= nodeEdgeVal;
                        nodeEdgeVal = edges[j].value;
                        nodeEdgeSum[i] += nodeEdgeVal;
                    }else{
                        if (edges[j].fromNode == i){
                            nodeEdgeSum[i] += edges[j].value;
                        }
                    }
                    break;
            }
        }
    }
    
    startNode = 0;
    startNodeVal = nodeEdgeSum[0];
    for(i=1; i<4; i++){
        if (nodeEdgeSum[i] < startNodeVal){
            startNode = i;
        }
    }

    return startNode;
}

void getMinEdge(struct edgeDetails edges[6],int fromNode, int *toNode, int *minEdge){
    int i, minEdgeSetInd;
    minEdgeSetInd = 0;
    for (i=0; i<6; i++){
    
        if (edges[i].fromNode == fromNode){
            if (minEdgeSetInd == 0){
                *minEdge = edges[i].value;
                *toNode = edges[i].toNode;
				minEdgeSetInd = 1;
            }else{
                if (edges[i].value < *minEdge){
                    *minEdge = edges[i].value;
                    *toNode = edges[i].toNode;
                }
            }
        }
    }
}
