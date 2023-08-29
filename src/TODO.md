# ttd
## Operational (todo)
- [ ] Collapse yapping structure from parsing - current one has too many levels
- [ ] Use precedence to decide structure of the yapping 
### decimals
- [ ] Would we want to allow us to do something like pass args like the following?
         `MyGrid.filterabove.(3.5)` or `MyGrid.filterabove(3.5)` or `MyGrid.filterbetween[3.5, 4.5]`
  - Might be a conflict, as `MyGrid.filterbetween["a", "b"]` typically resolves to
    `[MyGrid.filterbetweena, MyGrid.filterbetweenb]`
  - But it still may be useful to do something like `dictionary.wordsBetween["aardvark", "zebra"]`
    Problem comes in for `x = dictionary.wordsBetween`, `x["aardvark", "zebra"]`
  - We may want to use first and ensure we use the same name, s.t. `x = dictionary.wordsBetween`
    does not resolve. Will allow `wordsBetween` to act like an implementation function
    that can allow us to intern strings and more like the following
    https://openjdk.org/jeps/430
### Quotients
- [ ] Todo: see above. We should find out how we may be able to make this work by matching to a scope with
  a
### Maps
- [ ] We can use pairs or lists to match both key and value `value.a{a=b, b=c}`
### properties
- [ ] Properties must concat to a list, map, primitive, etc.
## Denotational (done)
### precedence (done)
- [x] `()`, allow to be concatenated to path
### lists
- [x] `[,]`, allow to be concatenated to path
### decimals
- [x] `0.0` requires both beginning and end digits. `.1` and `1.` are invalid, as it may link
to another scope operator.  
- this cannot be part of a path, and we prevent paths that start with `NATURAL.NATURAL`
  - ex. `sadf0.0asdf` will not work
  - May only work with precedence `asdf.(0.0).asdf`. 
    Case to think about: `asdf(0.1)asdf`
### quotients
- [x] May not be in a path, only works with precedence `sadf(3/4)asdf`, or `MyTree.getAbove.(3/4)`

### pairs
- [x] Pairs only work with precedence in paths
- [x] `"abc"x=a"abc"` will resolve to `("abc"x) = (a"abc")`
- [x] We need `"abc"(x=a)"abc"` to insert a pair here.

### maps
- [x] Works like lists `asdf{a=b, c=d}`
- [x] `value.a{a=b, b=c}"abc"`, so `value.{aaabc = b}`, `value.{ababc = c}`
- [x] `value.a{a=h, b=i}{c=j, d=k}`
- [x] `concat.map(A)and(B)` or `concat.[A, B]`

### properties
- [x] just use properties with precedence
- [x] `(asdf:section: value section2: value2 )asdf`

