Сделан форк репозитория Kotlin-Polytech/KotlinAsFirst2020

Клон форка

Репозиторий ssasha/KotlinAsFirst2021 добавлен в качестве апстрима upstream-my

Произведен fetch из добавленного апстрима

Создана ветка backport и произведен переход на неё

Произведен черри-пик из upstream-my с d535f3592006b8f2593c9f881d72c05164aadc13 по головного коммита апстрима (FETCH_HEAD)

В качестве второго апстрима upstream-theirs добавлен irreiku/KotlinAsFirst2021

Произведен fetch из upstream-theirs

Возврат на ветку master

Merge веток backport и upstream-theirs/master

Исправление конфликтов слияния через mergetool

Запись апстримов в файл remotes и коммит изменения

Запись истории команд и описание действий

Проверка графа с помощью gitk


  Id CommandLine                                                                                                                     
  -- -----------                                                                                                                     
   1 git clone https://github.com/ssassha/KotlinAsFirst2020                                                                          
   2 cd KotlinAsFirst2020                                                                                                            
   3 git remote add upstream-my https://github.com/ssassha/KotlinAsFirst2021                                                         
   4 git fetch upstream-my                                                                                                           
   5 git checkout -b backport                                                                                                        
   6 git cherry-pick d535f359...FETCH_HEAD                                                                                           
   7 git remote add upstream-theirs https://github.com/irreiku/KotlinAsFirst2021                                                     
   8 git fetch upstream-theirs                                                                                                       
   9 git checkout master                                                                                                             
  10 ls                                                                                                                              
  11 git merge backport upstream-theirs/master                                                                                       
  12 git mergetool                                                                                                                   
  13 git status                                                                                                                      
  14 git clean -f                                                                                                                    
  15 git status                                                                                                                      
  16 touch remotes.txt                                                                                                               
  17 git touch remotes.txt                                                                                                           
  18 cd master                                                                                                                       
  19 git status                                                                                                                      
  20 git commit                                                                                                                      
  21 git status                                                                                                                      
  22 git touch remotes.txt                                                                                                           
  23 touch remotes.txt                                                                                                               
  24 git status                                                                                                                      
  25 git log                                                                                                                         
  26 git status                                                                                                                      
  27 git remote -v                                                                                                                   
  28 touch remotes.txt                                                                                                               
  29 cd homework                                                                                                                     
  30 cd -                                                                                                                            
  31 cd                                                                                                                              
  32 cd                                                                                                                              
  33 cd/                                                                                                                             
  34 cd..                                                                                                                            
  35 touch remotes.txt                                                                                                               
  36 touch remotes.md                                                                                                                
  37 git touch remotes.txt                                                                                                           
  38 git remote -v > remotes                                                                                                         
  39 cd .\KotlinAsFirst2020\                                                                                                         
  40 git remote -v > remotes                                                                                                         
  41 cat remotes                                                                                                                     
  42 cat remotes                                                                                                                     
  43 cat remotes                                                                                                                     
  44 cat remotes                                                                                                                     
  45 cd..                                                                                                                            
  46 git remote -v > remotes                                                                                                         
  47 cd .\KotlinAsFirst2020\                                                                                                         
  48 cat remotes                                                                                                                     
  49 git commit -m 'final'                                                                                                                                                                                                                 


