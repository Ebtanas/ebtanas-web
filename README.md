# ebtanas

A website that provide excercises for high school students.

## Usage

To run the server do
```Bash
lein run <port>
# other way
# lein with-profile dev run <port>
```
Then to run figwheel while developing
```Bash
lein figwheel
```

The default port is 3000

In production, you don't need all of those
```Bash
lein cljsbuild once min
lein with-profile min run <port>
```

## License

Copyright © 2016

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
