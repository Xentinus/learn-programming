# Markdown

## Fejlécek

```md
# h1
## h2
### h3
```

## Betűk

*Dölt*

```md
*italic*
_italic_
```

**Kövér**

```md
**bold**
__bold__
```

## Listák

* Első
* Második

```md
* Első
* Második

- Első
- Második
```

## Kódok

### Egysoros kódok

Egysoros kódokat `` közé kell tenni

```md
Változó például a `sajt`
```

### Többsoros kódok

```js
codeFences.withLanguage()
```

A ``` után megkell mondani milyen nyelvű az

```md
```js
codeFences.withLanguage()
```

és ``` val be kell zárni egy sorral utánna!

## Képek

[img]: https://pbs.twimg.com/profile_banners/2437468446/1549596748/1500x500
![Image alt text][img]

```md
![Kép alt szövege](/path/to/img.jpg)

![Kép alt szövege](/path/to/img.jpg "Címe amikor ráviszed az egeret")

![Kép alt szövege][img]
[img]: https://pbs.twimg.com/profile_banners/2437468446/1549596748/1500x500
```

## Linkek

[Google link](http://google.com)

```md
[Google link](http://google.com)

<http://google.com>
```

## Megjegyzés blokkok

Az egymás után lévőket összekapcsolja eggyé.

> Ez egy megjegyzésblokk első része

```md
> Ez egy megjegyzésblokk első része
```

> Ez egy megjegyzésblokk első része
>> Ez pedig a második része

```md
> Ez egy megjegyzésblokk első része
>> Ez pedig a második része
```

## Horizontális vonal

----

```md
----
****
```

## Táblák

| Fejléc 1 | Fejléc 2 |
| --- | --- |
| sajt | cica |

```md
| Fejléc 1 | Fejléc 2 |
| --- | --- |
| sajt | cica |
```
