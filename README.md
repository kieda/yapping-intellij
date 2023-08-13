# yapping-intellij
Intellij Plugin for the Yapping Language

### Note on path segments
Path segments are concatable, and represented by placing multiple values together with no whitespace

Example path segments:
```
1)  abc`[0-9]+`"literal"
2)  "list."variable
3)  `~<`(list.length.`~/2`)
```

To disambiguate, `x.variable` is equivalent to `x."variable"` in the case where we have
a path segment consisting of a single name. To denote that we may want to use another variable,
we denote `x.(variable)`. Note that `x.variable"VAL"` may substitute `variable` and append
it to `"VAL"`.

