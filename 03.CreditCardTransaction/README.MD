CardHolder initates a CreditCardTransaction with the Merchant using their CreditCard
The Merchant verifies the CreditCardTransaction by using the CreditCardTransactionService
The CreditCardTransactionService will using [CardHolder, CreditCard, CreditCardTransaction] to verify with the bank

When a CH buys a product from M they swipe their CC.
A CCTransaction will be created with a uniqued TransactionID along with [CC.CardNumber, CC.CarHolderName, M.MerchantName]
A CCTService will take that CCTransaction and parse the CC.CardNumber to find the corresponding bank.
    [Bank]
        Verifies that the card number is valid
        Verifies if the CardHolder associated with the card matches the associated account
        Verifies if the balance limit is not exceded
    [Merchant]
        Verifies the merchant is on the merchant list

[Kiosk]
    [User swipes their credit card]
    CreditCardTransactionService(CreditCard, Merchant)
[Transaction]
    0. Extract Data
        [Merchant.MerchantName]
        [CreditCard.CardHolderName]
        [CreditCard.CardNumber]
    1. Verify Merchant is valid
        [Merchant.MerchantName \in CreditCardTransactionService.MerchantList]
    2. Verify Bank
        [Parse through CreditCard.CardNumber]
        [Find the corresponding Bank]
        [Bank.BankName \in CreditCardTransactionService.BankList]
    4. Verify Transaction
        [BankTransactionVerificationService(CreditCard.CardNumber, CreditCard.CardHolderName, TransactionAmount]
[Verification]
    0. Verify CardNumber
    1. Verify CardHolder
    2. Verify TransactionAmount does not exceed limit

CreditCard
    CardNumber
    CardHolderName

CreditCardTransaction
    TransactionID
    BankName
    CardHolderName
    MerchantName

!Merchant
    MerchantName

!Bank
    Bank Name

BankTransactionVerificationService
    CardHolderList
    CreditCardNumberList

CardHolder
    AccountNumber
    BalanceLimit
    CardHolderName
