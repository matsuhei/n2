# 概要

pprofの利用例を調べた

## pprofにて得られたprofiler

topを利用しての結果確認

```
fib

Showing nodes accounting for 4.42s, 99.55% of 4.44s total
Dropped 6 nodes (cum <= 0.02s)
      flat  flat%   sum%        cum   cum%
     4.26s 95.95% 95.95%      4.40s 99.10%  main.fib
     0.13s  2.93% 98.87%      0.13s  2.93%  runtime.newstack
     0.03s  0.68% 99.55%      0.03s  0.68%  runtime.usleep
         0     0% 99.55%      4.40s 99.10%  main.main
         0     0% 99.55%      4.40s 99.10%  runtime.main
         0     0% 99.55%      0.04s   0.9%  runtime.mstart
         0     0% 99.55%      0.04s   0.9%  runtime.mstart1
         0     0% 99.55%      0.04s   0.9%  runtime.sysmon

fib-http

Type: cpu
Time: Jul 26, 2021 at 9:48am (JST)
Duration: 30.15s, Total samples = 26.72s (88.61%)
Entering interactive mode (type "help" for commands, "o" for options)
(pprof) top
Showing nodes accounting for 26.43s, 98.91% of 26.72s total
Dropped 29 nodes (cum <= 0.13s)
      flat  flat%   sum%        cum   cum%
    25.31s 94.72% 94.72%     26.56s 99.40%  main.fib
     1.12s  4.19% 98.91%      1.12s  4.19%  runtime.newstack
         0     0% 98.91%     26.56s 99.40%  main.main
         0     0% 98.91%     26.56s 99.40%  runtime.main

```