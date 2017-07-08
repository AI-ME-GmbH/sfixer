# SFixer

Sfixer is a type safe wrapper for currency conversions in scala pulled from [sfixer.fixer.io](http://sfixer.fixer.io/). 
Sfixer uses [circe](https://github.com/circe/circe) and Jodatime. 

Sfixer is http framework agnostic in its core implementation, but will provide a (WIP) akka transport api.

Note: Currently Sfixer does not support querying by a subset of symbols. 
This is a work in progress library, and it is usable by pulling all rates 
(i.e pulling all symbols for historical rates, or using the default `latest` endpoint)

To use, first provide a Rates implementation. You can do this by consuming a Json from sfixer.fixer.io using `Rates.consume`, 
then unwrapping the option.

With the implicit rates, you can now perform any conversions in a type safe manner:
```
implicit val rates: Rates = ...

USD(100).convertTo[EUR] // Convert to typed Euros instance.
EUR(100).convertToValue[EUR] //Convert to unboxed Euros value 
```

You can also smash together a list of identifiers and values to generate a list of Currencies.

Assume a matrix with the form:

|     | Identifier    | Value |
| --- |:-------------:| -----:|
| 0   | EUR           | 1600  |
| 1   | USD           |   12  |
| 2   | AUD           |    1  |

Using `Currency.smash(identifier)(value)`, you can retrieve a generic list of currencies, which you can then converge into one value,
provided it is using the standard naming convention from the [ECB](http://www.ecb.europa.eu/stats/policy_and_exchange_rates/euro_reference_exchange_rates/html/index.en.html)

```
val unprocessed: List[(String, Double)] = ... //Assuming you have an identifier and a double

val currencyList: List[Currency] = unprocessed.map(u => Currency.smash(u._1)(u._2))

val audList : List[AUD] = currencyList.map(_.convertGenericToWrapped[AUD])

```

For more example usages: Look under the example in the akka package