Schema 相关的需求有哪些呢？

1. 获取flag的类型
2. 命令行中的flag，是否在Schema中存在 => Schema中是否包含flag
3. Schema的flag不能重复，重复会报错


对应的test case:
1. Given flag p, schema p:integer; When get type of p;  Then return integer;
2. Given flag p, schema p:integer; When check if schema contain p; Then return true;
3. Given flag p, schema l:boolean; When check if schema contain p; Then return false;
4. Given schema l:boolean l:integer; When validate schema; Then return error message "The schema flag is duplicated."