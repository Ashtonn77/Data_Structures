
class Item:

    def __init__(self, weight, value, idx):
        self.weight = weight
        self.value = value
        self.idx = idx


class Node:

    def __init__(self, node):
        self.upper = node.upper
        self.lower = node.lower
        self.tValue = node.tValue
        self.tWeight = node.tWeight
        self.level = node.level
        self.isSelected = node.isSelected


class Knapsack:

    def __init__(self, size, capacity):
        self.size = size
        self.capacity = capacity


    def getUpperBound(self, tWeight, tValue, idx, arr):
        weight = tWeight
        value = tValue

        for i in range(idx, len(arr)):
            if weight + arr[i].weight <= self.capacity:
                weight += arr[i].weight
                value -= arr[i].value
            else:
                value -= (self.capacity - weight) * (arr[i].weight / arr[i].value)
                break

        return value             


    def getLowerBound(self, tWeight, tValue, idx, arr):
        weight = tWeight
        value = tValue

        for i in range(idx, len(arr)):
            if weight + arr[i].weight <= self.capacity:
                weight += arr[i].weight
                value -= arr[i].value
            else:                
                break

        return value  


    def assign(self, temp, uBound, lBound, tValue, tWeight, flag, curLevel):

        temp.upperBound = uBound;
        temp.lowerBound = lBound;
        temp.totalWeight = tWeight;
        temp.totalValue = tValue;
        temp.isSelected = flag;
        temp.level = curLevel;        

    
    def solve(self, arr):
     
        arr.sort(key = lambda x: x.weight)

        current = Node(0, 0, 0, 0, 0, False)
        left = Node(0, 0, 0, 0, 0, False)
        right = Node(0, 0, 0, 0, 0, False)

        minLB = 0
        finalLB = float("inf")

        pq = MinHeap(1000);


        curPath = [False] * self.size
        finalPath = [False] * self.size
