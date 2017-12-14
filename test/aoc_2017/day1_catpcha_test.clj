(ns aoc-2017.day1-captcha-test
  (:require [clojure.test :refer :all]
            [aoc-2017.day1-captcha :refer :all]))

(deftest char->digit-test
  (is (= (char->digit \0) 0))
  (is (= (char->digit \1) 1))
  (is (= (char->digit \3) 3))
  (is (= (char->digit \5) 5))
  (is (= (char->digit \7) 7))
  (is (= (char->digit \9) 9)))

(deftest str->digit-list-test
  (is (= (str->digit-list "1234") '(1 2 3 4)))
  (is (= (str->digit-list "112233") '(1 1 2 2 3 3))))

(deftest first-two-match?-test
  (is (first-two-match? '(1 1)))
  (is (not (first-two-match? '(1 2)))))

(deftest ends-match?-test
  (is (ends-match? '(1 1)))
  (is (ends-match? '(1 2 1)))
  (is (ends-match? '(1 3 5 2 1)))
  (is (not (ends-match? '(1 2))))
  (is (not (ends-match? '(7 5 6 1 3 8 9)))))

(deftest captcha-count-pair-test
  (is (= (captcha-count-pair '(1 1)) 1))
  (is (= (captcha-count-pair '(2 2)) 2))
  (is (= (captcha-count-pair '(1 2 1)) 0))
  (is (= (captcha-count-pair '(1 3)) 0))
  (is (= (captcha-count-pair '(1 2 1 )) 0)))

(deftest captcha-count-to-end-test
  (is (= (captcha-count-to-end "1122") 3))
  (is (= (captcha-count-to-end "11122") 4))
  (is (= (captcha-count-to-end "112233") 6)))

(deftest captcha-count-last-element-test
  (is (= (captcha-count-last-element "11") 1))
  (is (= (captcha-count-last-element "121") 1))
  (is (= (captcha-count-last-element "77") 7))
  (is (= (captcha-count-last-element "777") 7)))

(deftest captcha-solve-test
  (is (= (captcha-solve "1122") 3))
  (is (= (captcha-solve "11122") 4))
  (is (= (captcha-solve "112233") 6))
  (is (= (captcha-solve "11") 2))
  (is (= (captcha-solve "121") 1))
  (is (= (captcha-solve "77") 14))
  (is (= (captcha-solve "777") 21)))

(deftest captcha-solve-the-challenge
  (is (= 1044
         (captcha-solve "111831362354551173134957758417849716877188716338227121869992652972154651632296676464285261171625892888598738721925357479249486886375279741651224686642647267979445939836673253446489428761486828844713816198414852769942459766921928735591892723619845983117283575762694758223956262583556675379533479458964152461973321432768858165818549484229241869657725166769662249574889435227698271439423511175653875622976121749344756734658248245212273242115488961818719828258936653236351924292251821352389471971641957941593141159982696396228218461855752555358856127582128823657548151545741663495182446281491763249374581774426225822474112338745629194213976328762985884127324443984163571711941113986826168921187567861288268744663142867866165546795621466134333541274633769865956692539151971953651886381195877638919355216642731848659649263217258599456646635412623461138792945854536154976732167439355548965778313264824237176152196614333748919711422188148687299757751955297978137561935963366682742334867854892581388263132968999722366495346854828316842352829827989419393594846893842746149235681921951476132585199265366836257322121681471877187847219712325933714149151568922456111149524629995933156924418468567649494728828858254296824372929211977446729691143995333874752448315632185286348657293395339475256796591968717487615896959976413637422536563273537972841783386358764761364989261322293887361558128521915542454126546182855197637753115352541578972298715522386683914777967729562229395936593272269661295295223113186683594678533511783187422193626234573849881185849626389774394351115527451886962844431947188429195191724662982411619815811652741733744864411666766133951954595344837179635668177845937578575117168875754181523584442699384167111317875138179567939174589917894597492816476662186746837552978671142265114426813792549412632291424594239391853358914643327549192165466628737614581458189732579814919468795493415762517372227862614224911844744711698557324454211123571327224554259626961741919243229688684838813912553397698937237114287944446722919198743189848428399356842626198635297851274879128322358195585284984366515428245928111112613638341345371"))))

(deftest rotate-list-left-test
  (is (= (rotate-list-left '(1 2 3)) '(2 3 1)))
  (is (= (rotate-list-left '(5 9 0 1 2)) '(9 0 1 2 5)))
  (is (= (rotate-list-left '(42)) '(42))))

(deftest n-ahead-matches?-test
  (is (n-ahead-matches? '(1 1) 1))
  (is (n-ahead-matches? '(1 2 1) 2))
  (is (n-ahead-matches? '(1 2 3 4 5 1) 5))
  (is (not (n-ahead-matches? '(1 2 1) 1))))

(deftest captcha-solve-2-test
  (is (= (captcha-solve-2 "1212") 6))
  (is (= (captcha-solve-2 "1221") 0))
  (is (= (captcha-solve-2 "123425") 4))
  (is (= (captcha-solve-2 "123123") 12))
  (is (= (captcha-solve-2 "12131415") 4)))

;; this test does work, but is disabled because it takes forever to run
;; (deftest captcha-solve-2-the-challenge
;;   (is (= 1054
;;          (captcha-solve-2 "111831362354551173134957758417849716877188716338227121869992652972154651632296676464285261171625892888598738721925357479249486886375279741651224686642647267979445939836673253446489428761486828844713816198414852769942459766921928735591892723619845983117283575762694758223956262583556675379533479458964152461973321432768858165818549484229241869657725166769662249574889435227698271439423511175653875622976121749344756734658248245212273242115488961818719828258936653236351924292251821352389471971641957941593141159982696396228218461855752555358856127582128823657548151545741663495182446281491763249374581774426225822474112338745629194213976328762985884127324443984163571711941113986826168921187567861288268744663142867866165546795621466134333541274633769865956692539151971953651886381195877638919355216642731848659649263217258599456646635412623461138792945854536154976732167439355548965778313264824237176152196614333748919711422188148687299757751955297978137561935963366682742334867854892581388263132968999722366495346854828316842352829827989419393594846893842746149235681921951476132585199265366836257322121681471877187847219712325933714149151568922456111149524629995933156924418468567649494728828858254296824372929211977446729691143995333874752448315632185286348657293395339475256796591968717487615896959976413637422536563273537972841783386358764761364989261322293887361558128521915542454126546182855197637753115352541578972298715522386683914777967729562229395936593272269661295295223113186683594678533511783187422193626234573849881185849626389774394351115527451886962844431947188429195191724662982411619815811652741733744864411666766133951954595344837179635668177845937578575117168875754181523584442699384167111317875138179567939174589917894597492816476662186746837552978671142265114426813792549412632291424594239391853358914643327549192165466628737614581458189732579814919468795493415762517372227862614224911844744711698557324454211123571327224554259626961741919243229688684838813912553397698937237114287944446722919198743189848428399356842626198635297851274879128322358195585284984366515428245928111112613638341345371"))))
