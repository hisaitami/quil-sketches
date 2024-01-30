# repl-lib

A library to use rebel-readline with vim-iced.

NOTE: This code is borrowed from the vim-iced document.
see https://github.com/liquidz/vim-iced

## Usage

Start the rebel-readline REPL.

```shell
% clj -M:rebel
[Rebel readline] Type :repl/help for online help info
user=>
```

Use `iced-rebel`.

```clojure
user=> (use 'iced-rebel)

rlwrap: warning: rlwrap appears to do nothing for clojure, which asks for
single keypresses all the time. Don't you need --always-readline
and possibly --no-children? (cf. the rlwrap manpage)

warnings can be silenced by the --no-warnings (-n) option

nil
```

Start nrepl server.

```clojure
user=> (start-nrepl-server!)
Cider nREPL server started on port 7888
nil
user=>
```

then in vim do `:IcedConnect`.

