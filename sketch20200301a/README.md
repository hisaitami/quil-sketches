# quil-minkowski

A Quil sketch designed to draw minkowski distance

inspired from https://qiita.com/scivola/items/ee37b686d0b36d6e9b39

![](https://github.com/hisaitami/quil-sketches/blob/master/sketch20200301a/screen.png)

## Usage

LightTable - open `core.clj` and press `Ctrl+Shift+Enter` to evaluate the file.

Emacs - run cider, open `core.clj` and press `C-c C-k` to evaluate the file.

REPL - run `(require 'quil-minkowski.core)`.

CLI - run `clj -M -e "(require 'quil-minkowski.core)"` or `clj -M -m quil-minkowski.core 3`

Run with different parameters from CLI

```shell
# p=1 Manhattan distance
% clj -M -m quil-minkowski.core 1

# p=2 Euclidean distance
% clj -M -m quil-minkowski.core 2

# p=3 ... 10
% clj -M -m quil-minkowski.core 3
% clj -M -m quil-minkowski.core 10
```

## License

Copyright (c) 2024 hisaitami
Distributed under the terms of the [MIT License](LICENSE)

